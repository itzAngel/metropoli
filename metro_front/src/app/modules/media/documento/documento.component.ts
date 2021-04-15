import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ModalModule } from 'ngb-modal';
import { NgxSpinnerService } from 'ngx-spinner';
import { Documento } from 'src/app/models/documento';
import { DocumentoService } from 'src/app/modules/media/documento/documento.service';
import * as uuid from 'uuid';
import { LoginService } from '../../base/login/login.service';
@Component({
  selector: 'app-documento',
  templateUrl: './documento.component.html',
  styleUrls: ['./documento.component.css']
})
export class DocumentoComponent implements OnInit {
  @ViewChild('documentoInputFile', {static: false}) documentoFile: ElementRef;
  formAct = false;
  documento: File;
  documentoMin: File;
  documentos: Documento[] = [];
  isProgrress=false;
  myId:string;
  constructor(private service: DocumentoService,public loginservice: LoginService, private router: Router, private spinner: NgxSpinnerService,private modalService: ModalModule) { }

  ngOnInit() {
    this.cargarDocumentos();
  }
  Agregar(){
    this.formAct=true;
  }
  Regresar(){
    this.formAct=false;
  }
  cargarDocumentos(): void {
    this.service.list().subscribe(
      data => {
        this.documentos = data;
      }
    );
  }

  borrar(id: string): void {
    this.isProgrress=true;
    this.service.delete(id).subscribe(
      data => {
        this.isProgrress=false;
        this.cargarDocumentos();
      },
      err => {
        this.spinner.hide();
        console.log(err);
      }
    );
  }

  onFileChange(event) {
    this.documento = event.target.files[0];
    const fr = new FileReader();
    fr.onload = (evento: any) => {
      this.documentoMin = evento.target.result;
    };
    fr.readAsDataURL(this.documento);
  }

  onUpload(): void {
    this.isProgrress=true;
    this.myId = uuid().replace(/-/g, '');
    this.service.upload(this.documento,this.myId).subscribe(
      data => {
        this.isProgrress=false;
        this.formAct=false;
        this.cargarDocumentos();
      },
      err => {
        alert(err.error.mensaje);
        this.isProgrress=false;
        this.reset();
      }
    );
  }

  reset(): void {
    this.documento = null;
    this.documentoMin = null;
    this.documentoFile.nativeElement.value = '';
  }
}
