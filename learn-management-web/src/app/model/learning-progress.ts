import {Course} from './course';

export class LearningProcess {
  id: number;
  studentUserName: string;
  course: Course;
  startDate: Date;
  endDate?: Date;
}
