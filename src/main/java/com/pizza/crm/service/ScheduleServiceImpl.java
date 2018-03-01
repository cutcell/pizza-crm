package com.pizza.crm.service;

import com.pizza.crm.model.Schedule;
import com.pizza.crm.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public void save(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public void delete(Long id) {
        if (scheduleRepository.existsById(id)){
            scheduleRepository.deleteById(id);
        }
    }

    @Override
    public Schedule getSchedule(Long id) {
        if (scheduleRepository.existsById(id)){
            return scheduleRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public Schedule getScheduleByName(String name) {
        return scheduleRepository.getScheduleByName(name);
    }

    @Override
    public List<Schedule> findAllSchedules() {
        return scheduleRepository.findAll();
    }
}
