import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router, RoutesRecognized} from '@angular/router';
import {filter, map, pairwise} from 'rxjs/operators';

@Component({
  selector: 'app-menu-template',
  templateUrl: './menu-template.component.html',
  styleUrls: ['./menu-template.component.scss']
})
export class MenuTemplateComponent implements OnInit {

  public pageTitle = '';
  public sidebarExpand = false;


  public sidenavMenu: SidenavMenuItem[] = [
    { key: SidenavMenuKey.courseAdmin, title: 'Course Management', link: 'course-admin' },
    { key: SidenavMenuKey.studentRegistration, title: 'Student Registration', link: 'student-registration' },
    { key: SidenavMenuKey.learningProgress, title: 'Learning Progress', link: 'learning-progress' },
  ];

  constructor(
    private readonly activatedRoute: ActivatedRoute,
    private readonly router: Router,
  ) {
  }

  ngOnInit(): void {
    // PAGE TITLE
    this.router.events
      .pipe(filter((event) => event instanceof NavigationEnd))
      .subscribe((title: any) => {
        this.pageTitle = title;
      });

  }

  toggleSideNav(expand: boolean): void {
    this.sidebarExpand = expand;
  }

}

export interface SidenavMenuItem {
  divisor?: boolean;
  key?: SidenavMenuKey;
  link?: string;
  title?: string;
}

export interface SidenavAction {
  action: () => void;
  divisor?: boolean;
  title?: string;
}

export enum SidenavMenuKey {
  courseAdmin,
  studentRegistration,
  learningProgress,
}
