package com.demo.project;

import com.demo.project.grpc.JsonIngestorGrpc;
import com.demo.project.grpc.IngestJsonRequest;
import com.demo.project.grpc.IngestJsonResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GrpcDataProcessorClient {
    public static void main(String[] args) throws Exception {
        String jsonFile = null;
        int concurrency = 10;
        int requests = 1000;
        String host = "localhost";
        int port = 9090;

        // Parse args
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--json":
                    jsonFile = args[++i];
                    break;
                case "--concurrency":
                    concurrency = Integer.parseInt(args[++i]);
                    break;
                case "--requests":
                    requests = Integer.parseInt(args[++i]);
                    break;
                case "--host":
                    host = args[++i];
                    break;
                case "--port":
                    port = Integer.parseInt(args[++i]);
                    break;
            }
        }

        if (jsonFile == null) {
            System.err.println("Usage: java -jar GrpcDataProcessorClient.jar --json <file> --concurrency <n> --requests <n> --host <host> --port <port>");
            System.exit(1);
        }

        byte[] jsonBytes = Files.readAllBytes(Paths.get(jsonFile));
        // Optionally, base64 encode if your proto expects it, otherwise just use the bytes
        // String base64Json = Base64.getEncoder().encodeToString(jsonBytes);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        JsonIngestorGrpc.JsonIngestorBlockingStub stub = JsonIngestorGrpc.newBlockingStub(channel);

        ExecutorService executor = Executors.newFixedThreadPool(concurrency);
        CountDownLatch latch = new CountDownLatch(requests);

        long start = System.nanoTime();
        for (int i = 0; i < requests; i++) {
            executor.submit(() -> {
                try {
                    IngestJsonRequest req = IngestJsonRequest.newBuilder()
                            .setJsonPayload(com.google.protobuf.ByteString.copyFrom(jsonBytes))
                            .build();
                    IngestJsonResponse resp = stub.ingestJson(req);
                    // Optionally, check resp.getStatus() or resp.getMessage()
                } catch (Exception e) {
                    System.err.println("Request failed: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
        long end = System.nanoTime();
        executor.shutdown();
        channel.shutdownNow();

        double elapsed = (end - start) / 1_000_000_000.0;
        double rps = requests / elapsed;
        System.out.printf("Total time: %.3f seconds\n", elapsed);
        System.out.printf("Requests per second: %.2f\n", rps);
    }
} 