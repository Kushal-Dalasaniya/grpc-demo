package com.demo;

import java.io.IOException;

import com.demo.service.EmployService;
import com.demo.service.UserService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(9010)
				.addService(new UserService())
				.addService(new EmployService())
				.build();
		server.start();
		
		System.out.println("Server is running on port " + server.getPort());
		server.awaitTermination();
	}

}
