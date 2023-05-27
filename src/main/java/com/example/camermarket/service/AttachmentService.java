package com.example.camermarket.service;

import com.example.camermarket.entities.Attachment;
import com.example.camermarket.repositories.AttachmentRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttachmentService {

private  final  AttachmentRepository attachmentRepository;

public List<Attachment> getAllAttachment(){
   return  attachmentRepository.findAll();
}


public Attachment getAttachment(long id){
   return  attachmentRepository.findById(id).orElseThrow(  () -> new IllegalArgumentException("not found"));
}


public  Attachment createAttachment( Attachment attachment){
   log.info(attachment.toString());
   return  attachmentRepository.save(attachment);
}

public  Attachment editAttachment(long id, Attachment attachment){

   log.info(attachment.toString());
    Attachment foundAttachment =  getAttachment(id);
    foundAttachment.setName(attachment.getName());
    foundAttachment.setIsMain(attachment.getIsMain());
    foundAttachment.setPath(attachment.getPath());
    log.info(foundAttachment.toString());

     return  attachmentRepository.save(foundAttachment);
}

public String deleteAttachment( long id){
    attachmentRepository.delete(getAttachment(id));
    return  "Attachment has deleted";
}

}
