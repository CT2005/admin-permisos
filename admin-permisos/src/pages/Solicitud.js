import { ProjectForm } from "../components/index.js";
import { Row, Col } from "react-bootstrap";
import Nav from "react-bootstrap/Nav";
import Tab from "react-bootstrap/Tab";
import Container from "react-bootstrap/Container";
import Button from "react-bootstrap/Button";
import ListGroup from "react-bootstrap/ListGroup";
import { useHistory } from "react-router-dom";
import { useEffect, useState } from "react";
import Form from "react-bootstrap/Form";
import InputGroup from "react-bootstrap/InputGroup";
export function Solicitud(props) {
  let history = useHistory();

  const { projectId } = props.params;
  console.log(projectId);
  const permiso = JSON.parse(localStorage.getItem(`permiso${projectId}`));
  useEffect(() => {
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
  });

  const volver = () => {
    history.push("/aprobar_permisos");
  };
  const [validated, setValidated] = useState(false);
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

  const handleSubmit = (event) => {
    const form = event.currentTarget;
    if (form.checkValidity() === false) {
      event.preventDefault();
      event.stopPropagation();
    }

    setValidated(true);
  };

  const aprobarPermiso = () => {
   
    const permiso = {
      nombre,
      indice,
      apellido,
      date,
      motivo,
      grado,
      celular,
      grado,
      motivo,
      justificacion,
      "estado":"aprobado",
      correo,
    };

  
    localStorage.setItem(`permiso${indice}`, JSON.stringify(permiso));
    history.push("/aprobar_permisoss");
  };
  
  const denegarPermiso = () => {
  
    const permiso = {
      nombre,
      indice,
      apellido,
      date,
      motivo,
      grado,
      celular,
      grado,
      motivo,
      justificacion,
      "estado":"denegado",
      correo,
    };

    localStorage.setItem(`permiso${indice}`, JSON.stringify(permiso));
    history.push("/aprobar_permisos");
  };
  return (
    <>
      <div className="d-flex justify-content-center p-5">
        <h1>Aprobar Permiso</h1>
        <hr />
      </div>
      <div className="d-flex justify-content-center p-5">
        <Form noValidate validated={validated} onSubmit={handleSubmit}>
          <Row className="mb-3">
            <Form.Group as={Col} md="3" controlId="validationCustom01">
              <Form.Label>Nombre Estudiante</Form.Label>
              <Form.Control
                required
                type="text"
                placeholder="Nombre"
                value={nombre}
                disabled
                onChange={(e) => setNombre(e.target.value)}
              />
            </Form.Group>
            <Form.Group as={Col} md="3" controlId="validationCustom02">
              <Form.Label>Apellido Estudiante </Form.Label>
              <Form.Control
                required
                type="text"
                placeholder="Apellido"
                value={apellido}
                disabled
                onChange={(e) => setApellido(e.target.value)}
              />
              <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            </Form.Group>
            <Form.Group as={Col} md="3" controlId="validationCustom02">
              <Form.Label>Grado estudiante </Form.Label>
              <Form.Control
                required
                type="text"
                placeholder="Grado"
                value={grado}
                disabled
                onChange={(e) => setGrado(e.target.value)}
              />
              <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            </Form.Group>
            <Form.Group as={Col} md="3" controlId="validationCustom02">
              <Form.Label>Celular Acudiente</Form.Label>
              <Form.Control
                required
                type="text"
                placeholder="Celular"
                value={celular}
                disabled
                onChange={(e) => setCelular(e.target.value)}
              />
              <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            </Form.Group>
            <Form.Group as={Col} md="3" controlId="validationCustomUsername">
              <Form.Label>Correo</Form.Label>
              <InputGroup hasValidation>
                <InputGroup.Text id="inputGroupPrepend">@</InputGroup.Text>
                <Form.Control
                  type="text"
                  placeholder="Correo"
                  aria-describedby="inputGroupPrepend"
                  required
                  value={correo}
                  disabled
                  onChange={(e) => setCorreo(e.target.value)}
                />
                <Form.Control.Feedback type="invalid">
                  Please choose a username.
                </Form.Control.Feedback>
              </InputGroup>
            </Form.Group>
            <Form.Group as={Col} md="2" controlId="validationCustom02">
              <Form.Label>Fecha del Permiso</Form.Label>
              <Form.Control
                type="date"
                value={date}
                disabled
                onChange={(e) => setDate(e.target.value)}
                rows={3}
              />
            </Form.Group>
            <Form.Group as={Col} md="3" controlId="validationCustom02">
              <Form.Label>Motivo </Form.Label>
              <Form.Control
                required
                type="text"
                value={motivo}
                disabled
                onChange={(e) => setMotivo(e.target.value)}
              />
              <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            </Form.Group>
            <Form.Group as={Col} md="3" controlId="validationCustom02">
              <Form.Label>Estado </Form.Label>
              <Form.Control
                required
                type="text"
                defaultValue={estado}
                disabled
                onChange={(e) => setMotivo(e.target.value)}
              />
             
            </Form.Group>
          </Row>

          <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
            <Form.Label>justificacion</Form.Label>
            <Form.Control
              as="textarea"
              rows={3}
              value={justificacion}
              disabled
              onChange={(e) => setJustificacion(e.target.value)}
            />
          </Form.Group>
          <Container>
            <Row>
              <Col>
                <Button variant="primary" size="lg" onClick={()=>aprobarPermiso()}>
                  Aprobar
                </Button>
              </Col>
              <Col>
                <Button variant="primary" size="lg" onClick={() =>denegarPermiso()}>
                  Denegar
                </Button>
              </Col>
              <Col>
                <Button variant="primary" size="lg" onClick={() => volver()}>
                  volver
                </Button>
              </Col>
            </Row>
          </Container>
        </Form>
      </div>
    </>
  );
}
