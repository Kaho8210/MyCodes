import React from 'react'
import Button from 'react-bootstrap/Button';

import Form from 'react-bootstrap/Form';
import { builtinModules } from 'module';
import Card from 'react-bootstrap/Card';


const LoginPage = () => {
  return (
    <div className="App">
      <header>
        <div style={{textAlign: 'center' , paddingTop: '50px'}}>
          <h2>空き家探し</h2>
          <h2>Vacant House Finder</h2>
        </div>
      </header>
      
      <div style={{textAlign: 'center' , paddingTop: '180px'}}>
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
          <Button href="/Home">submit</Button>
        </Form>
        </div>
        </div>
    
  )
}

export default LoginPage;




