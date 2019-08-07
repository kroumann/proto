



/*

@RequestMapping(value = "/image/{imageid}",method= RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
public @ResponseBody byte[] getImageWithMediaType(@PathVariable int imageid) throws IOException {
    InputStream in = new ByteArrayInputStream(getImage(imageid));
    return IOUtils.toByteArray(in);
    }
    */