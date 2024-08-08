import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTimeTableComponent } from './create-time-table.component';

describe('CreateTimeTableComponent', () => {
  let component: CreateTimeTableComponent;
  let fixture: ComponentFixture<CreateTimeTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateTimeTableComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateTimeTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
