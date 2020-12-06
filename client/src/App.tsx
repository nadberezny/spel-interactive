import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';

function App() {

  const [expr, setExpr] = useState("");
  const [exprValue, setExprValue] = useState("");

  const handleSubmit = () => {
    fetch(`http://localhost:8080/eval?expression=${expr}`)
      .then(response => response.text())
      .then(res => setExprValue(res))
  }

  return (
    <div className="App">
       <p>
         {exprValue}
       </p>
       <form>
        <label>
          Name:
          <input type="text" value={expr} onChange={e => setExpr(e.target.value)} />
        </label>
      </form>
      <button onClick={handleSubmit}>
        Click me
      </button>
    </div>
  );
}

export default App;
