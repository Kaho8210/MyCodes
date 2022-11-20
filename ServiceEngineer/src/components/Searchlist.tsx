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

function OffcanvasExample() {
  return (
    <React.Fragment>
    <><div className="Searchlist">
      <header>
      <Placeholder xs={12} bg="primary" />
      <h1>イベント一覧</h1>
      <Placeholder xs={12} bg="primary" />
      </header>
    </div><>
        {['sm'].map((expand) => (
          <Navbar bg="light" expand={expand} className="mb-3">
            <Container fluid>
              <Navbar.Brand href="#">イベント検索</Navbar.Brand>
              <Navbar.Toggle aria-controls={`offcanvasNavbar-expand-${expand}`} />
              <Navbar.Offcanvas
                id={`offcanvasNavbar-expand-${expand}`}
                aria-labelledby={`offcanvasNavbarLabel-expand-${expand}`}
                placement="end"
              >
                <Offcanvas.Header closeButton>
                  <Offcanvas.Title id={`offcanvasNavbarLabel-expand-${expand}`}>
                    Offcanvas
                  </Offcanvas.Title>
                </Offcanvas.Header>
                <Offcanvas.Body>
                  <Nav className="justify-content-end flex-grow-1 pe-3">

                    <NavDropdown
                      title="並べ替え"
                      id={`offcanvasNavbarDropdown-expand-${expand}`}
                    >

                      <NavDropdown.Divider />
                      <NavDropdown.Item href="#action5">
                        近い空き家
                      </NavDropdown.Item>
                      <NavDropdown.Item href="#action5">
                        開催日時が近い
                      </NavDropdown.Item>
                    </NavDropdown>
                  </Nav>
                  <Form className="d-flex">
                    <Form.Control
                      type="search"
                      placeholder="検索"
                      className="me-2"
                      aria-label="search" />
                    <Button variant="outline-success">検索</Button>
                  </Form>
                </Offcanvas.Body>
              </Navbar.Offcanvas>
            </Container>
          </Navbar>
        ))}
</></>
<Container>
  <Row>

<Col>
<Card>
      <Card.Img variant="top" src = "https://3.bp.blogspot.com/-5j1dGX51e-Q/V2vXoQCiDYI/AAAAAAAA730/1Sd6hAHOp2Y3F9zGMLjmtLxx0-5l-lnswCLcB/s800/building_house4.png" width = "150" height = "150" />
      <Card.Body>
      <Card.Title>イベント名</Card.Title>
        <Card.Text>
          <ListGroup>
            <ListGroup.Item>主催者</ListGroup.Item>
            <ListGroup.Item>イベント概要</ListGroup.Item>
            <ListGroup.Item>空き家情報</ListGroup.Item>
            <ListGroup.Item>空き家概要</ListGroup.Item>
            <ListGroup.Item>開催日時</ListGroup.Item>
            <ListGroup.Item>受付時間</ListGroup.Item>
            <ListGroup.Item>参加定員</ListGroup.Item>
            </ListGroup>
        </Card.Text>
        <Button variant="primary">参加確認画面へ</Button> 
      </Card.Body>
    </Card>
    </Col>
    <Col>
    <Card>
      <Card.Img variant="top" src="https://4.bp.blogspot.com/-OdiJTRSpoyo/V2vXp7B4WPI/AAAAAAAA74A/tP5y-qSY5EY9nTYyzVAknVAvfRqtheupQCLcB/s800/building_house8.png" width = "150" height = "150"/>
      <Card.Body>
      <Card.Title>イベント名</Card.Title>
        <Card.Text>
        <ListGroup>
            <ListGroup.Item>主催者</ListGroup.Item>
            <ListGroup.Item>イベント概要</ListGroup.Item>
            <ListGroup.Item>空き家情報</ListGroup.Item>
            <ListGroup.Item>空き家概要</ListGroup.Item>
            <ListGroup.Item>開催日時</ListGroup.Item>
            <ListGroup.Item>受付時間</ListGroup.Item>
            <ListGroup.Item>参加定員</ListGroup.Item>
            </ListGroup>
        </Card.Text>
        <Button variant="primary">参加確認画面へ</Button> 
      </Card.Body>
    </Card>
    </Col>
    <Col>
    <Card>
      <Card.Img variant="top" src="https://2.bp.blogspot.com/-ohl41tIW1a0/V2vXoJN4eVI/AAAAAAAA73w/jMiHgV4uFrgQNfjgG9hVSo_5ObhPc0qVACLcB/s800/building_house3.png" width = "150" height = "150" />
      <Card.Body>
      <Card.Title>イベント名</Card.Title>
        <Card.Text>
        <ListGroup>
            <ListGroup.Item>主催者</ListGroup.Item>
            <ListGroup.Item>イベント概要</ListGroup.Item>
            <ListGroup.Item>空き家情報</ListGroup.Item>
            <ListGroup.Item>空き家概要</ListGroup.Item>
            <ListGroup.Item>開催日時</ListGroup.Item>
            <ListGroup.Item>受付時間</ListGroup.Item>
            <ListGroup.Item>参加定員</ListGroup.Item>
            </ListGroup>
        </Card.Text>
        <Button variant="primary">参加確認画面へ</Button> 
      </Card.Body>
    </Card>
    </Col>
    </Row>
    <br />
    <Row>
    <Col>
    <Card>
      <Card.Img variant="top" src="https://4.bp.blogspot.com/-SxQGjSVxPS0/V2vXo47pgEI/AAAAAAAA734/aXNhcKRftNM2k0U6N_J2tVPknw0-dbKCACLcB/s800/building_house5.png" width = "150" height = "150"/>
      <Card.Body>
      <Card.Title>イベント名</Card.Title>
        <Card.Text>
        <ListGroup>
            <ListGroup.Item>主催者</ListGroup.Item>
            <ListGroup.Item>イベント概要</ListGroup.Item>
            <ListGroup.Item>空き家情報</ListGroup.Item>
            <ListGroup.Item>空き家概要</ListGroup.Item>
            <ListGroup.Item>開催日時</ListGroup.Item>
            <ListGroup.Item>受付時間</ListGroup.Item>
            <ListGroup.Item>参加定員</ListGroup.Item>
            </ListGroup>
        </Card.Text>
        <Button variant="primary">参加確認画面へ</Button> 
      </Card.Body>
    </Card>
    </Col>
    <Col>
    <Card>
      <Card.Img variant="top" src="https://2.bp.blogspot.com/-ohl41tIW1a0/V2vXoJN4eVI/AAAAAAAA73w/jMiHgV4uFrgQNfjgG9hVSo_5ObhPc0qVACLcB/s800/building_house3.png" width = "150" height = "150"/>
      <Card.Body>
      <Card.Title>イベント名</Card.Title>
        <Card.Text>
        <ListGroup>
            <ListGroup.Item>主催者</ListGroup.Item>
            <ListGroup.Item>イベント概要</ListGroup.Item>
            <ListGroup.Item>空き家情報</ListGroup.Item>
            <ListGroup.Item>空き家概要</ListGroup.Item>
            <ListGroup.Item>開催日時</ListGroup.Item>
            <ListGroup.Item>受付時間</ListGroup.Item>
            <ListGroup.Item>参加定員</ListGroup.Item>
            </ListGroup>
        </Card.Text>
        <Button variant="primary">参加確認画面へ</Button> 
      </Card.Body>
    </Card>
    </Col>
    <Col>
    <Card>
      <Card.Img variant="top" src="https://4.bp.blogspot.com/-OdiJTRSpoyo/V2vXp7B4WPI/AAAAAAAA74A/tP5y-qSY5EY9nTYyzVAknVAvfRqtheupQCLcB/s800/building_house8.png" width = "150" height = "150"/>
      <Card.Body>
      <Card.Title>イベント名</Card.Title>
        <Card.Text>
        <ListGroup>
            <ListGroup.Item>主催者</ListGroup.Item>
            <ListGroup.Item>イベント概要</ListGroup.Item>
            <ListGroup.Item>空き家情報</ListGroup.Item>
            <ListGroup.Item>空き家概要</ListGroup.Item>
            <ListGroup.Item>開催日時</ListGroup.Item>
            <ListGroup.Item>受付時間</ListGroup.Item>
            <ListGroup.Item>参加定員</ListGroup.Item>
            </ListGroup>
        </Card.Text>
        <Button variant="primary">参加確認画面へ</Button> 
      </Card.Body>
    </Card>
    </Col>
    </Row>
    </Container>
      </React.Fragment>
        );
}
        export default OffcanvasExample;
