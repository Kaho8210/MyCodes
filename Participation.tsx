import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Offcanvas from 'react-bootstrap/Offcanvas';
import Card from 'react-bootstrap/Card';
import React from 'react';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Placeholder from 'react-bootstrap/Placeholder';
import ListGroup from 'react-bootstrap/ListGroup';

function Participation() {
  return (
    <React.Fragment>
      <div className="Participation">
        <header>
          <Placeholder xs={12} bg="danger" />
          <h1>確認</h1>
          <Placeholder xs={12} bg="danger" />
        </header>
        <body>
          <Card className="text-center">
            <div className = "container">
            <Card.Img variant="top" src="https://4.bp.blogspot.com/-OdiJTRSpoyo/V2vXp7B4WPI/AAAAAAAA74A/tP5y-qSY5EY9nTYyzVAknVAvfRqtheupQCLcB/s800/building_house8.png" className = "img-fluid"/>
            </div>
            <Card.Body>
              <Card.Title>イベント名</Card.Title>
              <Card.Text>
              <ListGroup>
      <ListGroup.Item>主催者</ListGroup.Item>
      <ListGroup.Item>イベント概要</ListGroup.Item>
      <ListGroup.Item>空き家住所</ListGroup.Item>
      <ListGroup.Item>空き家概要</ListGroup.Item>
      <ListGroup.Item>開催日時</ListGroup.Item>
      <ListGroup.Item>持ち物</ListGroup.Item>
      <ListGroup.Item>備考</ListGroup.Item>
    </ListGroup>
              </Card.Text>
              <Button variant="danger">イベントに参加する</Button>{' '}
            </Card.Body>
          </Card>

        </body>

      </div>

    </React.Fragment>
  );
}
export default Participation;