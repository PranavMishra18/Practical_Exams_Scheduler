import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SetExaminationsComponent } from './set-examinations.component';

describe('SetExaminationsComponent', () => {
  let component: SetExaminationsComponent;
  let fixture: ComponentFixture<SetExaminationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SetExaminationsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SetExaminationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
