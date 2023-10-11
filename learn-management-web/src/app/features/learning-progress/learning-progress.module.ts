import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LearningProgressRoutingModule } from './learning-progress-routing.module';
import { LearningProgressComponent } from './learning-progress/learning-progress.component';


@NgModule({
  declarations: [LearningProgressComponent],
  imports: [
    CommonModule,
    LearningProgressRoutingModule
  ]
})
export class LearningProgressModule { }
