import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ModalModule } from 'ngb-modal';
import { NgxSpinnerService } from 'ngx-spinner';
import { Multimedia } from 'src/app/models/multimedia';
import { MultimediaService } from 'src/app/modules/media/multimedia/multimedia.service';
import * as uuid from 'uuid';
import { LoginService } from '../../base/login/login.service';
@Component({
  selector: 'app-multimedia',
  templateUrl: './multimedia.component.html',
  styleUrls: ['./multimedia.component.css']
})
export class MultimediaComponent implements OnInit {
  formAct = false;
  isProgrress=false;
  @ViewChild('multimediaInputFile', {static: false}) multimediaFile: ElementRef;
  multimedia: File;
  multimediaMin: File;
  multimedias: Multimedia[] = [];
  myId:string;
  constructor(private service: MultimediaService,public loginservice: LoginService, private router: Router, private spinner: NgxSpinnerService,private modalService: ModalModule) { }

  ngOnInit() {
    this.cargarMultimedias();
  }
  Agregar(){
    this.formAct=true;
  }
  Regresar(){
    this.formAct=false;
  }
  cargarMultimedias(): void {
    this.service.list().subscribe(
      data => {
        this.multimedias = data;
      }
    );
  }

  borrar(id: string): void {
    this.isProgrress=true;
    this.service.delete(id).subscribe(
      data => {
        this.isProgrress=false;
        this.cargarMultimedias();
      },
      err => {
        this.spinner.hide();
        console.log(err);
      }
    );
  }

  onFileChange(event) {
    this.multimedia = event.target.files[0];
    const fr = new FileReader();
    fr.onload = (evento: any) => {
      this.multimediaMin = evento.target.result;
    };
    fr.readAsDataURL(this.multimedia);
  }

  onUpload(): void {
    this.isProgrress=true;
    this.myId = uuid().replace(/-/g, '');
    this.service.upload(this.multimedia,this.myId).subscribe(
      data => {
        this.isProgrress=false;
        this.formAct=false;
        this.cargarMultimedias();
      },
      err => {
        alert(err.error.mensaje);
        this.isProgrress=false;
        this.reset();
      }
    );
  }

  reset(): void {
    this.multimedia = null;
    this.multimediaMin = null;
    this.multimediaFile.nativeElement.value = '';
  }
  
}
