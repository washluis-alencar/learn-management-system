import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CourseAdministrationRoutingModule } from './course-administration-routing.module';
import { CourseAdministrationComponent } from './course-administration/course-administration.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {NgxMaskModule} from 'ngx-mask';


@NgModule({
  declarations: [CourseAdministrationComponent],
    imports: [
        CommonModule,
        CourseAdministrationRoutingModule,
        MatFormFieldModule,
        MatInputModule,
        ReactiveFormsModule,
        MatButtonModule,
        NgxMaskModule,
        FormsModule
    ]
})
export class CourseAdministrationModule { }
