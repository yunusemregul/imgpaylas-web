import React, { useEffect, useState } from "react";
import DivBackground from "../components/DivBackground";
import Header from "../components/Header";
import axios from "axios";
import Masonry from "react-masonry-css";
import ImageBox from "../components/ImageBox";

export default function Home() {
  const [images, setImages] = useState([]);

  useEffect(() => {
    axios.get("/api/v1/image/all").then((res) => {
      if (res.status === 200) {
        setImages(res.data);
      }
    });
    return () => {};
  }, []);

  return (
    <div className="box" style={{ height: "auto" }}>
      <Header />
      <DivBackground backgroundColor="#444444">
        <Masonry
          breakpointCols={3}
          className="my-masonry-grid"
          columnClassName="my-masonry-grid_column"
        >
          {images.map((image) => {
            return <ImageBox key={image.id} data={image} />;
          })}
        </Masonry>
      </DivBackground>
    </div>
  );
}
