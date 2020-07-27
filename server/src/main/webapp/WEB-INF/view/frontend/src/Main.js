import React from "react";
import { withRouter } from "react-router";
import content from "./assets/content.png";
import Header from "./Header";
import DivBackground from "./DivBackground";

function Main() {
  return (
    <div className="box">
      <Header />
      <DivBackground></DivBackground>
    </div>
  );
}

export default withRouter(Main);
