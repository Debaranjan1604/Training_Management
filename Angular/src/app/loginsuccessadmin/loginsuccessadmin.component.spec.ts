import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginsuccessadminComponent } from './loginsuccessadmin.component';

describe('LoginsuccessadminComponent', () => {
  let component: LoginsuccessadminComponent;
  let fixture: ComponentFixture<LoginsuccessadminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginsuccessadminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginsuccessadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
