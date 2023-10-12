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
      this.courseService.save(courseData).subscribe(
        () => {
          alert('Course saved successfully');
          this.form.reset();
          this.router.navigate(['/']);
        },
        () => {
          alert('Error saving course');
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
