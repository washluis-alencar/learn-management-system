import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRegistrationRoutingModule } from './student-registration-routing.module';
import {MenuModule} from '../../menu/menu.module';
import { StudentRegistrationComponent } from './student-registration/student-registration.component';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {NgxMaskModule} from 'ngx-mask';
import {ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [StudentRegistrationComponent],
  imports: [
    CommonModule,
    StudentRegistrationRoutingModule,
    MenuModule,
    MatProgressBarModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    NgxMaskModule.forChild(),
    ReactiveFormsModule
  ]
})
export class StudentRegistrationModule { }
