package com.demo.project.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class JsonIngestorGrpc {

  private JsonIngestorGrpc() {}

  public static final java.lang.String SERVICE_NAME = "JsonIngestor";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.demo.project.grpc.IngestJsonRequest,
      com.demo.project.grpc.IngestJsonResponse> getIngestJsonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IngestJson",
      requestType = com.demo.project.grpc.IngestJsonRequest.class,
      responseType = com.demo.project.grpc.IngestJsonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.project.grpc.IngestJsonRequest,
      com.demo.project.grpc.IngestJsonResponse> getIngestJsonMethod() {
    io.grpc.MethodDescriptor<com.demo.project.grpc.IngestJsonRequest, com.demo.project.grpc.IngestJsonResponse> getIngestJsonMethod;
    if ((getIngestJsonMethod = JsonIngestorGrpc.getIngestJsonMethod) == null) {
      synchronized (JsonIngestorGrpc.class) {
        if ((getIngestJsonMethod = JsonIngestorGrpc.getIngestJsonMethod) == null) {
          JsonIngestorGrpc.getIngestJsonMethod = getIngestJsonMethod =
              io.grpc.MethodDescriptor.<com.demo.project.grpc.IngestJsonRequest, com.demo.project.grpc.IngestJsonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "IngestJson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.project.grpc.IngestJsonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.project.grpc.IngestJsonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JsonIngestorMethodDescriptorSupplier("IngestJson"))
              .build();
        }
      }
    }
    return getIngestJsonMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JsonIngestorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JsonIngestorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JsonIngestorStub>() {
        @java.lang.Override
        public JsonIngestorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JsonIngestorStub(channel, callOptions);
        }
      };
    return JsonIngestorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static JsonIngestorBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JsonIngestorBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JsonIngestorBlockingV2Stub>() {
        @java.lang.Override
        public JsonIngestorBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JsonIngestorBlockingV2Stub(channel, callOptions);
        }
      };
    return JsonIngestorBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JsonIngestorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JsonIngestorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JsonIngestorBlockingStub>() {
        @java.lang.Override
        public JsonIngestorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JsonIngestorBlockingStub(channel, callOptions);
        }
      };
    return JsonIngestorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JsonIngestorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JsonIngestorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JsonIngestorFutureStub>() {
        @java.lang.Override
        public JsonIngestorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JsonIngestorFutureStub(channel, callOptions);
        }
      };
    return JsonIngestorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void ingestJson(com.demo.project.grpc.IngestJsonRequest request,
        io.grpc.stub.StreamObserver<com.demo.project.grpc.IngestJsonResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIngestJsonMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service JsonIngestor.
   */
  public static abstract class JsonIngestorImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return JsonIngestorGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service JsonIngestor.
   */
  public static final class JsonIngestorStub
      extends io.grpc.stub.AbstractAsyncStub<JsonIngestorStub> {
    private JsonIngestorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JsonIngestorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JsonIngestorStub(channel, callOptions);
    }

    /**
     */
    public void ingestJson(com.demo.project.grpc.IngestJsonRequest request,
        io.grpc.stub.StreamObserver<com.demo.project.grpc.IngestJsonResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIngestJsonMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service JsonIngestor.
   */
  public static final class JsonIngestorBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<JsonIngestorBlockingV2Stub> {
    private JsonIngestorBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JsonIngestorBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JsonIngestorBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.demo.project.grpc.IngestJsonResponse ingestJson(com.demo.project.grpc.IngestJsonRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIngestJsonMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service JsonIngestor.
   */
  public static final class JsonIngestorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<JsonIngestorBlockingStub> {
    private JsonIngestorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JsonIngestorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JsonIngestorBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.demo.project.grpc.IngestJsonResponse ingestJson(com.demo.project.grpc.IngestJsonRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIngestJsonMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service JsonIngestor.
   */
  public static final class JsonIngestorFutureStub
      extends io.grpc.stub.AbstractFutureStub<JsonIngestorFutureStub> {
    private JsonIngestorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JsonIngestorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JsonIngestorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.project.grpc.IngestJsonResponse> ingestJson(
        com.demo.project.grpc.IngestJsonRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIngestJsonMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INGEST_JSON = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INGEST_JSON:
          serviceImpl.ingestJson((com.demo.project.grpc.IngestJsonRequest) request,
              (io.grpc.stub.StreamObserver<com.demo.project.grpc.IngestJsonResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getIngestJsonMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.demo.project.grpc.IngestJsonRequest,
              com.demo.project.grpc.IngestJsonResponse>(
                service, METHODID_INGEST_JSON)))
        .build();
  }

  private static abstract class JsonIngestorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JsonIngestorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.demo.project.grpc.JsonIngestorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("JsonIngestor");
    }
  }

  private static final class JsonIngestorFileDescriptorSupplier
      extends JsonIngestorBaseDescriptorSupplier {
    JsonIngestorFileDescriptorSupplier() {}
  }

  private static final class JsonIngestorMethodDescriptorSupplier
      extends JsonIngestorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    JsonIngestorMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (JsonIngestorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JsonIngestorFileDescriptorSupplier())
              .addMethod(getIngestJsonMethod())
              .build();
        }
      }
    }
    return result;
  }
}
