package com.example.demo.helloMetaverseController;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloMetaverseControllerTest {

	@Test
	void greeting() {
		HelloMetaverse controller = new HelloMetaverse();
		String response = controller.greeting("Hari Seldon");
		assertEquals("Hello, Hari Seldon", response);
	}
}
