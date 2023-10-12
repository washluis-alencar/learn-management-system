import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Student} from '../../../model/student';
import {StudentService} from '../../../core/services/student.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-student-registration',
  templateUrl: './student-registration.component.html',
  styleUrls: ['./student-registration.component.scss']
})
export class StudentRegistrationComponent implements OnInit {
  loading = false;
  public form!: FormGroup;

  constructor(
    private readonly formBuilder: FormBuilder,
    private readonly studentService: StudentService,
    private readonly router: Router) { }

  ngOnInit(): void {
    // address, phoneNumber, username, password, firstName, lastName
    this.form = this.formBuilder.group({
      email: new FormControl('', [Validators.required, Validators.email]),
      dateOfBirth: new FormControl('', [Validators.required, Validators.minLength(10)]),
      firstName: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required]),
      username: new FormControl('', [Validators.required]),
      phoneNumber: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
    });
  }

  save(): void {
    if (this.form.valid) {
      this.loading = true;
      const student: Student = this.form.value;
      student.dateOfBirth = new Date(this.form.value.dateOfBirth).toISOString();
      this.studentService.save(student).subscribe(
        () => {
          alert('Student saved successfully');
          this.form.reset();
          this.router.navigate(['/']);
        },
        (error) => {
          alert('Error saving student: ' + error?.error.message);
          this.loading = false;
        }, () => {
          this.loading = false;
        }
      );
    }
  }
}
