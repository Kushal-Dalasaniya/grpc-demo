package com.demo.service;

import com.demo.grpc.APIResponse;
import com.demo.grpc.Empty;
import com.demo.grpc.LoginRequest;
import com.demo.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		System.out.println("Inside user login");
		
		String username=request.getUsername();
		String password=request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		
		if(username.equals(password)) 
			response.setResponseCode(200).setResponseMessage("Success");
		else 
			response.setResponseCode(500).setResponseMessage("Invalid");
		
		/* Sent response */
		responseObserver.onNext(response.build());
		
		/* Close gRPC connection */
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		System.out.println("Inside logout");
		APIResponse response = APIResponse.newBuilder().setResponseCode(200).setResponseMessage("Logged out").build();
		
		/* Sent response */
		responseObserver.onNext(response);
		
		/* Close gRPC connection */
		responseObserver.onCompleted();
	}
	
}
