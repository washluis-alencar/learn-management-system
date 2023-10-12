import { Component, OnInit } from '@angular/core';
import {Course} from '../../../model/course';
import {CourseService} from '../../../core/services/course.service';
import {LearningProgressService} from '../../../core/services/learning-progress.service';
import {LearningProgress} from '../../../model/learning-progress';
import {HourLoggingDialogComponent} from '../../../shared/hour-logging/hour-logging-dialog/hour-logging-dialog.component';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-learning-progress',
  templateUrl: './learning-progress.component.html',
  styleUrls: ['./learning-progress.component.scss']
})
export class LearningProgressComponent implements OnInit {
  courses: Course[] = [];
  progress: LearningProgress[] = [];
  studentUserName = '';
  step = 1;
  loading = false;


  constructor(private readonly courseService: CourseService,
              private readonly learningProgressService: LearningProgressService,
              private readonly dialog: MatDialog){ }

  ngOnInit(): void {
    this.courseService.findAll().subscribe(courses => this.courses = courses);
  }

  nextStep(): void {
    if (this.step === 1) {
      this.learningProgressService.findByStudentUserName(this.studentUserName)
        .subscribe(progress => {
          this.progress = progress;
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
  }

  isEnrollable(course: Course): boolean {
    return !this.progress.some(p => p.course.id === course.id);
  }

  isFinishable(course: Course): boolean {
    return this.progress.some(p => p.course.id === course.id && !p.endDate);
  }
}
