public boolean areSiblings(File f1, File f2) {
    // implement me
        return f1.getParentFile().getName().equals(f2.getParentFile().getName());
}