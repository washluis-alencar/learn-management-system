import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LearningProgressRoutingModule } from './learning-progress-routing.module';
import { LearningProgressComponent } from './learning-progress/learning-progress.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {HourLoggingModule} from '../../shared/hour-logging/hour-logging.module';


@NgModule({
  declarations: [LearningProgressComponent],
  imports: [
    CommonModule,
    LearningProgressRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    HourLoggingModule
  ]
})
export class LearningProgressModule { }
