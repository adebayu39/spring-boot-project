package com.miniproject.api.service;

import com.miniproject.api.entity.Pocket;

public interface PocketService {
    public Pocket getPocketById(String id);

    public Pocket savePocket(Pocket pocket);

    public Pocket editPocket(Pocket pocket);

    public void deletePocket(String id);
}
