import React from "react";
import "./App.css";
import Header from "./Header";
import content from "./assets/content.png";

function App() {
  return (
    <div>
      <Header />
      <div style={{ overflow: "hidden" }}>
        <img src={content} alt="content-background" />
      </div>
    </div>
  );
}

export default App;
