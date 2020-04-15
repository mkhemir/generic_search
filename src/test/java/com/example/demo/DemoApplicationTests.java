package com.example.demo;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	DeviceDataRepository deviceDataRepository;

	private static Logger logger = Logger.getLogger("logg");
	@Test
	void tertyy() {
		SearchDto searchDto = new SearchDto();
		OperationTypeDto<Long> op1 = new OperationTypeDto<Long>(2L, "<=");
		OperationTypeDto<Integer> op2 = new OperationTypeDto<Integer>(200, ">");
		searchDto.setCode(op2);
		searchDto.setId(op1);
		SearchFormatter<SearchDto> formatter = new SearchFormatter<SearchDto>();
		String res = formatter.formatTO(searchDto);
		logger.log(Level.WARNING, res);
		final Node rootNode = new RSQLParser().parse(res);
		Specification<Device> spec = rootNode.accept(new SearchVisitor<Device>());
		List<Device> result = deviceDataRepository.findAll(spec);

	}

}
