import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LearningProgressRoutingModule } from './learning-progress-routing.module';
import { LearningProgressComponent } from './learning-progress/learning-progress.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {HourLoggingModule} from '../../shared/hour-logging/hour-logging.module';
import {MatCardModule} from '@angular/material/card';
import {NgxMaskModule} from 'ngx-mask';
import {MatSelectModule} from '@angular/material/select';
import {MatOptionModule} from '@angular/material/core';
import {MatRadioModule} from '@angular/material/radio';


@NgModule({
  declarations: [LearningProgressComponent],
  imports: [
    CommonModule,
    LearningProgressRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    HourLoggingModule,
    MatCardModule,
    NgxMaskModule,
    MatSelectModule,
    MatOptionModule,
    ReactiveFormsModule,
    MatRadioModule
  ]
})
export class LearningProgressModule { }
