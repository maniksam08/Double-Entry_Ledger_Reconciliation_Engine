package service;

import dto.Auditresponse;

import java.util.UUID;

public interface AdminService {
    Auditresponse audit(UUID accountId);
}
