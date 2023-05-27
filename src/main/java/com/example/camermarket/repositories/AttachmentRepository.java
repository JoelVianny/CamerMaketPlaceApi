package com.example.camermarket.repositories;

import com.example.camermarket.entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository  extends JpaRepository<Attachment,Long> {
}
