import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRegistrationRoutingModule } from './student-registration-routing.module';
import {MenuModule} from '../../menu/menu.module';
import { StudentRegistrationComponent } from './student-registration/student-registration.component';


@NgModule({
  declarations: [StudentRegistrationComponent],
  imports: [
    CommonModule,
    StudentRegistrationRoutingModule,
    MenuModule
  ]
})
export class StudentRegistrationModule { }
