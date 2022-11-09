import { ProjectForm } from "../components/index.js";
import { Row, Col } from "react-bootstrap";
import Nav from "react-bootstrap/Nav";
import Tab from "react-bootstrap/Tab";
import Container from "react-bootstrap/Container";
import Button from "react-bootstrap/Button";
import ListGroup from "react-bootstrap/ListGroup";
import { useHistory } from "react-router-dom";
import { useEffect, useState } from "react";
export function EditProject(props) {
  let history = useHistory();
  const [date, setDate] = useState("");
  const [nombre, setNombre] = useState("");
  const [apellido, setApellido] = useState("");
  const [indice, setIndice] = useState("");
  const [grado, setGrado] = useState("");
  const [celular, setCelular] = useState("");
  const [correo, setCorreo] = useState("");
  const [motivo, setMotivo] = useState("");
  const [estado, setEstado] = useState("");
  const [justificacion, setJustificacion] = useState("");
 
  const { projectId } = props.params;
  console.log(projectId);
  const permiso = JSON.parse(localStorage.getItem(`permiso${projectId}`));
  useEffect(() => {
    if(nombre != ""){
      setNombre(permiso.nombre);
    setApellido(permiso.apellido);
    setGrado(permiso.grado);
    setCelular(permiso.celular);
    setCorreo(permiso.correo);
    setMotivo(permiso.motivo);
    setEstado(permiso.estado);
    setDate(permiso.date);
    setJustificacion(permiso.justificacion);
    setIndice(permiso.indice);
    }
  });
  
  const volver = () => {
    history.push("/ver_permisos");
  };

  return (
    <div className="content " >
      <h1>Permiso para {motivo}</h1>
      <br />

      <Container className="p-5">
        {["xxl"].map((breakpoint) => (
          <ListGroup key={breakpoint} horizontal={breakpoint} className="my-2">
            <ListGroup.Item>
              Nombre del estudiante: {nombre}
            </ListGroup.Item>
            <ListGroup.Item>
              {" "}
              <p>Apellidos: {apellido}</p>
            </ListGroup.Item>
            <ListGroup.Item>Fecha: {date}</ListGroup.Item>
            <ListGroup.Item>Grado: {grado}</ListGroup.Item>
            <ListGroup.Item>Correo: {correo}</ListGroup.Item>
            <ListGroup.Item>
              numero telefonico: {celular}
            </ListGroup.Item>
            <ListGroup.Item>
              Justificación: br {justificacion}
            </ListGroup.Item>
            <ListGroup.Item>Estado: {estado}</ListGroup.Item>
          </ListGroup>
        ))}
        <div className="d-grid gap-2">
          <Button variant="primary" size="lg" onClick={() => volver()}>
            volver
          </Button>
        </div>
      </Container>
    </div>
  );
}
