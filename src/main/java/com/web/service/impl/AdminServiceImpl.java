package com.web.service.impl;

import com.web.mapper.AdminMapper;
import com.web.pojo.Admin;
import com.web.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    public final AdminMapper adminMapper;
    @Override
    public Admin login(Admin admin) {
        return adminMapper.getByUsernameAndPassword(admin);
    }
}
