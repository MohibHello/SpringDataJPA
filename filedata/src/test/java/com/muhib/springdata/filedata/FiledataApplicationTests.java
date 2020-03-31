package com.muhib.springdata.filedata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FiledataApplicationTests {

	@Autowired
	ImageRepository repo;

	@Test
	void testImage() throws IOException {

		Image image = new Image();
		image.setId(5);
		image.setName("800kb");

		File file = new File("C:\\Users\\muhib\\Downloads\\nt.jpg"); // create file object by passing location of file

		byte[] filecontent = new byte[(int) file.length()]; // create byte array of file.length

		FileInputStream inputStream = new FileInputStream(file); // create FilleInputStream object to read content of
																	// file
		inputStream.read(filecontent); // read from file and append/store it in filecontent of byte

		image.setData(filecontent); // pass byte[] filecontent

		repo.save(image);
		inputStream.close();
	}

	@Test
	void testReadImage() {

		Image image = repo.findById(5L).get();

		File file = new File("C:/Users/muhib/Downloads/Music/" + image.getName()+".jpg"); 

		FileOutputStream stream = null;

		try {
			stream = new FileOutputStream(file);
			stream.write(image.getData());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
