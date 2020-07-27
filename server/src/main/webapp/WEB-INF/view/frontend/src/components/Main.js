import React from "react";
import { withRouter } from "react-router";
import DivBackground from "./DivBackground";
import Header from "./Header";

function Main() {
  return (
    <div className="box">
      <Header />
      <DivBackground></DivBackground>
    </div>
  );
}

export default withRouter(Main);
