package com.example.camermarket.controller;

import com.example.camermarket.entities.Attachment;
import com.example.camermarket.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/attachment")
public class AttachmentController {
    private  final AttachmentService attachmentService;

    @GetMapping
    public List<Attachment> getAllAttachment(){
        return attachmentService.getAllAttachment();
    }

    @GetMapping("/{id}")

    public Attachment getAttachment(@PathVariable long id){
        return attachmentService.getAttachment(id);
    }

    @PostMapping
    public Attachment createAttachment(@RequestBody Attachment attachment){
        return  attachmentService.createAttachment(attachment);

    }

    @PutMapping("/{id}")
    public Attachment editAttachment(@PathVariable long id, @RequestBody Attachment attachment){

        return  attachmentService.editAttachment(id,attachment);
    }

    @DeleteMapping("/{id}")
    public String  removeAttachment(@PathVariable long id){
        return   attachmentService.deleteAttachment(id);
    }
}
