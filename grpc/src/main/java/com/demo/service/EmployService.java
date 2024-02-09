package com.demo.service;


import com.demo.grpc.employGrpc.employImplBase;
import com.demo.grpc.id;
import com.demo.grpc.name;

import io.grpc.stub.StreamObserver;

public class EmployService extends employImplBase{

	@Override
	public void getName(id request, StreamObserver<name> responseObserver) {
		System.out.println("inside employ service");
		
		name nm = name.newBuilder().setName("test").build();
		responseObserver.onNext(nm);
		
		/* Close gRPC connection */
		responseObserver.onCompleted();
	}

}
