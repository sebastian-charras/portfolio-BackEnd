package com.sebastian.portfolio.controller;

import com.sebastian.portfolio.model.entities.Project;
import com.sebastian.portfolio.model.exceptions.ProjectNotFoundException;
import com.sebastian.portfolio.model.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjectController {

    private final ProjectRepository projectRepository;

    @GetMapping("/api/project")
    public List<Project> all() {
        return projectRepository.findAll();
    }

    @GetMapping("/api/project/{id}")
    public Project one(@PathVariable Integer id) {
        return projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @PostMapping("/api/project")
    @PreAuthorize("isAuthenticated()")
    public Project newProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PutMapping("/api/project/{id}")
    @PreAuthorize("isAuthenticated()")
    public Project replaceProject(@PathVariable Integer id, @RequestBody Project newProject) {
        return projectRepository.findById(id).map(project -> {
            project.setCompleted(newProject.getCompleted());
            project.setDescription(newProject.getDescription());
            project.setPeriod(newProject.getPeriod());
            project.setTitle(newProject.getTitle());
            project.setUrl(newProject.getUrl());
            return projectRepository.save(project);
        }).orElseGet(() -> {
            newProject.setId(id);
            return projectRepository.save(newProject);
        });
    }

    @DeleteMapping("/api/project/{id}")
    @PreAuthorize("isAuthenticated()")
    public void deleteProject(@PathVariable Integer id) {
        projectRepository.deleteById(id);
    }
}
