import {Component, OnInit} from '@angular/core';
import {Course} from '../../../model/course';
import {CourseService} from '../../../core/services/course.service';
import {LearningProgressService} from '../../../core/services/learning-progress.service';
import {LearningProgress} from '../../../model/learning-progress';
import {FormBuilder, Validators} from '@angular/forms';
import {TaskCategory} from '../../../model/enums/task-category';
import {StudentLog} from '../../../model/student-log';
import {StudentLogService} from '../../../core/services/student-log.service';
import {zip} from 'rxjs';

@Component({
  selector: 'app-learning-progress',
  templateUrl: './learning-progress.component.html',
  styleUrls: ['./learning-progress.component.scss']
})
export class LearningProgressComponent implements OnInit {
  taskCategories: string[] = [TaskCategory.PRACTICING, TaskCategory.WATCHING_VIDEOS, TaskCategory.RESEARCHING];
  courses: Course[] = [];
  progress: LearningProgress[] = [];
  studentLogs: StudentLog[] = [];

  studentUserName = '';
  step = 1;
  loading = false;
  formLogHours: any;
  courseSelected: Course;

  constructor(private readonly courseService: CourseService,
              private readonly learningProgressService: LearningProgressService,
              private readonly formBuilder: FormBuilder,
              private readonly logService: StudentLogService){ }

  ngOnInit(): void {
    this.courseService.findAll().subscribe(courses => this.courses = courses);
    this.formLogHours = this.formBuilder.group({
      date: ['', [Validators.required]],
      taskCategory: ['', [Validators.required]],
      taskDescription: ['', [Validators.required]],
      timeSpent: [0, [Validators.required]]
    });

  }

  nextStep(): void {
    if (this.step === 1) {
      zip(this.learningProgressService.findByStudentUserName(this.studentUserName),
        this.logService.findAllByStudentUserName(this.studentUserName))
        .subscribe(([progress, logs]) => {
          this.progress = progress;
          this.studentLogs = logs;
          this.step++;
        }, () => alert('Error loading learning progress'));
    }
  }

  enrollCourse(course: Course): void {
    this.loading = true;
    const learningProgress: LearningProgress = {
      id: null,
      studentUserName: this.studentUserName,
      course,
      startDate: new Date()
    };
    this.learningProgressService.save(learningProgress).subscribe(() => {
      this.progress.push(learningProgress);
      this.loading = false;
    }, () => this.loading = false);
  }

  finishCourse(course: Course): void {
    this.loading = true;
    const learningProgress = this.progress.find(p => p.course.id === course.id);
    learningProgress.endDate = new Date();
    this.learningProgressService.update(learningProgress).subscribe(() => {
      this.loading = false;
    }, () => this.loading = false);
  }

  logHours(course: Course): void {
    this.courseSelected = course;
  }

  isEnrollable(course: Course): boolean {
    return !this.progress.some(p => p.course.id === course.id);
  }

  isFinishable(course: Course): boolean {
    return this.progress.some(p => p.course.id === course.id && !p.endDate);
  }

  saveLog(): void {
    if (this.formLogHours.valid) {
      const logData: StudentLog = this.formLogHours.value;
      logData.learningProgressId = this.progress.find(p => p.course.id === this.courseSelected.id).id;
      logData.date = new Date(logData.date).toISOString();
      this.logService.save(logData).subscribe((log) => {
        this.formLogHours.reset();
        this.courseSelected = null;
        this.studentLogs.push(log);
      }, error => alert('Error saving log'));
    } else {
      alert('Form is invalid. Please check the fields.');
    }
  }
}
