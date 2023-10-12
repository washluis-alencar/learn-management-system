package br.com.challenge.presentation;

import br.com.challenge.domain.LearningProgress;
import br.com.challenge.exception.EntityNotFoundException;
import br.com.challenge.mapper.LearningProgressMapper;
import br.com.challenge.presentation.representation.LearningProgressRepresentation;
import br.com.challenge.service.LearningProgressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ApiPath.LEARNING_PROGRESS)
public class LearningProgressController {

    private final LearningProgressService learningProgressService;

    public LearningProgressController(LearningProgressService learningProgressService) {
        this.learningProgressService = learningProgressService;
    }

    @PostMapping
    public LearningProgressRepresentation save(@RequestBody LearningProgressRepresentation representation) throws EntityNotFoundException {
        if (representation.getId() == null) {
            LearningProgress learningProgress = learningProgressService
                    .enrollStudentInCourse(representation.getStudentUserName(), representation.getCourse());
            return LearningProgressMapper.convertToRepresentation(learningProgress);
        }
        throw new IllegalArgumentException("This endpoint is only for creating new learning progresses");
    }

    @PutMapping("/{id}")
    public LearningProgressRepresentation update(@PathVariable Long id, @RequestBody LearningProgressRepresentation representation) throws EntityNotFoundException {
        if (representation.getId() != null && representation.getId().equals(id)) {
            LearningProgress learningProgress = learningProgressService.update(
                    LearningProgressMapper.convertToLearningProgress(representation));
            return LearningProgressMapper.convertToRepresentation(learningProgress);
        }
        throw new IllegalArgumentException("This endpoint is only for updating existing learning progresses");
    }

    // get learning progress by studentUserName request param
    @GetMapping("/student")
    public List<LearningProgressRepresentation> getLearningProgressByStudentUserName(@RequestParam String studentUserName) throws EntityNotFoundException {
        List<LearningProgress> learningProgress = learningProgressService.findByStudentUserName(studentUserName);
        return learningProgress.stream()
                .map(LearningProgressMapper::convertToRepresentation)
                .collect(Collectors.toList());
    }
}
