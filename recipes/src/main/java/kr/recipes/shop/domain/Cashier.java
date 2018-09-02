package kr.recipes.shop.domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Cashier {
	private final static Logger logger = LoggerFactory.getLogger(Cashier.class);

	@Autowired
	private MessageSource messageSource;

	@Value("checkout")
	private String fileName;
	@Value("/Users/won.s.h/workspace/recipes")
	private String path;
	private BufferedWriter writer;

	public Cashier() {
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void checkout(ShoppingCart cart) throws IOException {
		writer.write(new Date() + "\t" + cart.getItems() + "\r\n");
		writer.flush();
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@PostConstruct
	public void openFile() throws IOException {
		File targetDir = new File(path);
		if (!targetDir.exists()) {
			targetDir.mkdir();
		}
		File checkoutFile = new File(path, fileName + ".txt");
		if (!checkoutFile.exists()) {
			checkoutFile.createNewFile();
		}

		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(checkoutFile, true)));
	}
	
	@PreDestroy
	public void closeFile() throws IOException {
		writer.close();
	}
}
