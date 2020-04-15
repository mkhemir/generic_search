package com.example.demo;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class DeviceDataService {

    private final Logger log = LoggerFactory.getLogger(DeviceDataService.class);

    @Autowired
    private DeviceDataRepository deviceDataRepository;


    /**
     *  Get all the deviceData.
     *
     *  @search the RSQL search string
     *  @param pageable the pagination information
     *  @return the list of entities
     */

    public Page<Device> findAll(Pageable pageable, String search) {
        log.info("Request to get all Device");
        Page<Device> result;
        if(search != null) {
            final Node rootNode = new RSQLParser().parse(search);
            Specification<Device> spec = rootNode.accept(new SearchVisitor<>());
            result = deviceDataRepository.findAll(spec, pageable);
        }
        else {
            result = deviceDataRepository.findAll(pageable);
        }

       // return result.map(deviceData -> deviceDataMapper.deviceDataToDeviceDataDTO(deviceData));
        return  null;
    }
}