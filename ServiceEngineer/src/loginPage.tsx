import React from 'react';
import './App.css';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Image from "./5034544_s.jpg";
import Card from 'react-bootstrap/Card';

function App() {
  return (
    <div className="App">
      <header>
      <Card className="bg-dark text-white">
      <img src={Image}/>
      <Card.ImgOverlay style={{color: 'black'}}>
        <h2>空き家探し</h2>
        <h2>Vacant House Finder</h2>
      
      </Card.ImgOverlay>
    </Card>
    </header>
        <Form>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Email address</Form.Label>
            <Form.Control type="email" placeholder="Enter email" />
            <Form.Text className="text-muted">
              We'll never share your email with anyone else.
            </Form.Text>
          </Form.Group>
    
          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Password</Form.Label>
            <Form.Control type="password" placeholder="Password" />
          </Form.Group>
          <Form.Group className="mb-3" controlId="formBasicCheckbox">
            <Form.Check type="checkbox" label="Check me out" />
          </Form.Group>
          <Button variant="primary" type="submit">
            Submit
          </Button>
        </Form>
        </div>
  );
}

export default App;