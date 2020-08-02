import React, { useEffect, useState } from "react";
import DivBackground from "../components/DivBackground";
import Header from "../components/Header";
import axios from "axios";
import Masonry from "react-masonry-css";
import ImageBox from "../components/ImageBox";

export default function Home() {
  const [images, setImages] = useState([]);
  const [likes, setLikes] = useState([]);

  /*
    images: database deki tüm fotoğraflar
    likes: kullanıcının beğendiği fotoğraflar
  */

  useEffect(() => {
    axios.get("/api/v1/image/all").then((res) => {
      if (res.status === 200) {
        setImages(res.data);
      }
    });
    axios.get("/api/v1/like/my_likes").then((res) => {
      if (res.status === 200) {
        setLikes(res.data);
      }
    });
    return () => {};
  }, []);

  return (
    <div className="box" style={{ height: "auto" }}>
      <Header title="Ana Sayfa" />
      <DivBackground backgroundColor="#444444">
        <Masonry
          breakpointCols={3}
          className="my-masonry-grid"
          columnClassName="my-masonry-grid_column"
        >
          {images.map((image) => {
            return (
              <ImageBox
                key={image.id}
                data={image}
                userLiked={likes.includes(image.id)}
              />
            );
          })}
        </Masonry>
      </DivBackground>
    </div>
  );
}
