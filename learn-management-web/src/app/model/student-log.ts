import {TaskCategory} from './enums/task-category';

export class StudentLog {
  id: number;
  learningProgressId: number;
  date: string;
  taskCategory: TaskCategory;
  taskDescription: string;
  timeSpent: number;
}
