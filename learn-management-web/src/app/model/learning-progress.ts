import {Course} from './course';

export class LearningProgress {
  id: number;
  studentUserName: string;
  course: Course;
  startDate: Date;
  endDate?: Date;
}
