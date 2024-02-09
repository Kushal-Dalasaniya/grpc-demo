package client.grpc;

import java.io.IOException;

import client.grpc.protos.APIResponse;
import client.grpc.protos.Empty;
import client.grpc.protos.LoginRequest;
import client.grpc.protos.employGrpc;
import client.grpc.protos.employGrpc.employBlockingStub;
import client.grpc.protos.id;
import client.grpc.protos.name;
import client.grpc.protos.userGrpc;
import client.grpc.protos.userGrpc.userBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	public static void main(String[] args) throws IOException, InterruptedException {
		
ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9010).usePlaintext().build();
		
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		LoginRequest loginRequest = LoginRequest.newBuilder()
				.setUsername("kal")
				.setPassword("kal")
				.build();
		
		APIResponse loginResponse = userStub.login(loginRequest);
		System.out.println(loginResponse.toString());
		
		APIResponse logoutResponse = userStub.logout(Empty.newBuilder().build());
		System.out.println(logoutResponse.toString());
		
		employBlockingStub empStub = employGrpc.newBlockingStub(channel);
		name nm = empStub.getName(id.newBuilder().setId(2).build());
		
		System.out.println(nm.toString());
	}
}
