package com.demo.project;

import com.demo.project.grpc.JsonIngestorGrpc;
import com.demo.project.grpc.JsonIngestorProto;
import com.demo.project.grpc.IngestJsonRequest;
import com.demo.project.grpc.IngestJsonResponse;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class JsonIngestorService extends JsonIngestorGrpc.JsonIngestorImplBase {
    @Autowired
    private JsonDataRepository jsonDataRepository;
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Override
    public void ingestJson(IngestJsonRequest request, StreamObserver<IngestJsonResponse> responseObserver) {
        String jsonPayload = new String(request.getJsonPayload().toByteArray());
        try {
            // Save to Postgres
            JsonData entity = new JsonData();
            entity.setPayload(jsonPayload);
            jsonDataRepository.save(entity);

            // Publish to Kafka
            kafkaProducerService.sendMessage(jsonPayload);

            IngestJsonResponse response = IngestJsonResponse.newBuilder()
                    .setStatus("SUCCESS")
                    .setMessage("Data ingested successfully.")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            IngestJsonResponse response = IngestJsonResponse.newBuilder()
                    .setStatus("FAILURE")
                    .setMessage("Error: " + e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
} 