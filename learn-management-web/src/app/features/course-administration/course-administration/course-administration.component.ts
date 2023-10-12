import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {CourseService} from '../../../core/services/course.service';
import {Course} from '../../../model/course';

@Component({
  selector: 'app-course-administration',
  templateUrl: './course-administration.component.html',
  styleUrls: ['./course-administration.component.scss']
})
export class CourseAdministrationComponent implements OnInit {

  loading = false;
  step = 1;
  form!: FormGroup;
  userName = '';

  constructor(
    private readonly formBuilder: FormBuilder,
    private readonly courseService: CourseService,
    private readonly router: Router) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      courseCode: ['', Validators.required],
      courseName: ['', Validators.required],
      startDate: [''],
      finalDate: [''],
      description: [''],
    });
  }

  save(): void {
    if (this.form.valid) {
      this.loading = true;
      const courseData: Course = this.form.value;
      courseData.adminUserName = this.userName;
      courseData.startDate = courseData.startDate ? new Date(this.form.value.startDate).toISOString() : null;
      courseData.finalDate = courseData.startDate ? new Date(this.form.value.finalDate).toISOString() : null;
      this.courseService.save(courseData).subscribe(
        () => {
          alert('Course saved successfully');
          this.form.reset();
          this.router.navigate(['/']);
        },
        (error) => {
          alert('Error saving course: ' + error?.error.message);
          this.loading = false;
        }, () => {
          this.loading = false;
        }
      );
    }
  }

  nextStep(): void {
    this.step++;
  }
}
